$(document).ready(function(){
	var downloadURL='';
	var config = {
		    apiKey: "AIzaSyD3hA9hxZ5BEL0QVbvcXfKFCwY29JpjF64",
		    authDomain: "dbcloset-53a0d.firebaseapp.com",
		    databaseURL: "https://dbcloset-53a0d.firebaseio.com",
		    storageBucket: "dbcloset-53a0d.appspot.com",
		    messagingSenderId: "959120012711"
		  };
  firebase.initializeApp(config);
  var storage = firebase.storage();
  var storageRef = storage.ref();
  var male=["T Shirts","Shirts","Trousers","Jeans","Shorts","Caps","Jackets","Hoodies","Shoes","Others"];
  var female=["Tops","Shirts","Trousers","Jeans","Shorts","Jackets","Shoes","Party Wear","Ethnic Wear","Wedding wear","Others"];
  $('input[type=radio][name=gender][value=male]').prop("checked","checked"); 
  var options="";
  for(i=0;i<male.length;i++){
	  options=options+"<option>"+male[i]+"</option>";
  }
  $(".i-category").html(options);
  
  $("#showDetails").click(function(){
	  if($(this).is(":checked")){
		  $(this).val("hide");
		  $("#showDetails").siblings("label").html("Donate as unknown user");
	  }
	  else{
		  $(this).val("show");
		  $("#showDetails").siblings("label").html("Donate as myself");
	  }
  });
  
  $('input[type=radio][name=gender]').change(function() {
	  var options="";
	  
	  if($(this).val()=="male"){
		  for(i=0;i<male.length;i++){
			  options=options+"<option>"+male[i]+"</option>";
		  }
	  }
	  if($(this).val()=="female"){
		  for(j=0;j<female.length;j++){
			  options=options+"<option>"+female[j]+"</option>";
		  }
	  }
	  $(".i-category").html(options);
  });
	$(".signup").click(function(){
		$(".login").toggle();
		$(".signup-block").toggle();
		$(".background").css("height","130%");
		});

		$(".goLogin").click(function(){
		$(".login").toggle();
		$(".signup-block").toggle();
		$(".background").css("height","100%");
		});
		$("#newsSubscription").change(function(){
			if($(this).is(":checked")){
				$(this).val("true");
			}
			else{
				$(this).val("false");
			}
		})
		$(".user").click(function(){
			$(".user-popup,.mask-a").toggle();
			$(".cart-popup-div").hide();
		})
		$(".mask-a").click(function(){
		$(".user-popup,.mask-a").toggle();
	})
		if($(".activePage").val()=="shop"){
			$(".shop").addClass("pageActive");
			$(".donate").removeClass("pageActive");
		}
		if($(".activePage").val()=="donate"){
			$(".donate").addClass("pageActive");
			$(".shop").removeClass("pageActive");
		}
		$(".donate").click(function(){
			$(".donateServlet").submit();
		})
		$(".shop").click(function(){
			$(".ItemsRetrievalServlet").submit();
		})
		$(".upload_action").click(function(e){
			e.preventDefault();
			var data = new FormData();
			jQuery.each(jQuery('.imgData')[0].files, function(i, file) {
			    data.append('img-'+i, file);
			});
			
			var uploadTask=storageRef.child('images/'+$(".imgData")[0].files[0].name).put($('.imgData')[0].files[0]);
			uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED, // or 'state_changed'
					  function(snapshot) {
					    // Get task progress, including the number of bytes uploaded and the total number of bytes to be uploaded
					    var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
					    console.log('Upload is ' + progress + '% done');
					    switch (snapshot.state) {
					      case firebase.storage.TaskState.PAUSED: // or 'paused'
					        console.log('Upload is paused');
					        break;
					      case firebase.storage.TaskState.RUNNING: // or 'running'
					        console.log('Upload is running');
					        break;
					    }
					  }, function(error) {
					  switch (error.code) {
					    case 'storage/unauthorized':
					      // User doesn't have permission to access the object
					      break;

					    case 'storage/canceled':
					      // User canceled the upload
					      break;
					      
					    case 'storage/unknown':
					      // Unknown error occurred, inspect error.serverResponse
					      break;
					  }
					}, function() {
					  // Upload completed successfully, now we can get the download URL
					  downloadURL = uploadTask.snapshot.downloadURL;
					  $(".img-upload").attr("src",downloadURL);
					  $(".imgURL").val(downloadURL);
					});
		
		})
		$(".getOrders").click(function(){
			$(".getOrdersForm").submit();
		})
		$(".logout").click(function(){
			$(".logoutForm").submit();
		})
})