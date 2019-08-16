$(document).ready(function(){
	$(".itemApprove").click(function(){
		var data={"itemID":$(this).parents(".itemBlock").find(".itemid").val()};
		var elem=$(this).parents(".itemBlock");
		$.ajax({
	        url:'ItemActionsServlet',
	        type:'get',
	        data:data,
	        cache:false,
	        success:function(data){
	        	console.log(data);
	        	$(elem).html("<div class='notificationSent'>Item is approved and sent to shopping list <span class='glyphicon glyphicon-ok'></span></div>");
	        },
	        error:function(){
	         
	        }
	     });
	});
	$(".itemRemove").click(function(){
		var data={"itemID":$(this).parents(".itemBlock").find(".itemid").val()};
		var elem=$(this).parents(".itemBlock");
		$.ajax({
	        url:'ItemActionsServlet',
	        type:'post',
	        data:data,
	        cache:false,
	        success:function(data){
	        	console.log(data);
	        	$(elem).fadeOut(100);
	        },
	        error:function(){
	         
	        }
	     });
	});
	
	
})