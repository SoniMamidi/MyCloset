$(document).ready(function(){
	$(".cart").click(function(){
		$(".cart-popup-div,.mask-b").toggle();
		$(".user-popup").hide();
	});
	$(".mask-b").click(function(){
		$(".cart-popup-div,.mask-b").toggle();
	})
	$.ajax({
        url:'CartItemsServlet',
        type:'get',
        cache:false,
        success:function(data){
        	console.log(data);
        	
        $(".cartItemsContainer").html(data);
        $(".CartCount").html($(".cartItem").length);
        },
        error:function(){
         
        }
     });
	$(".addtoCart").click(function(){
		var price=$(".addtoCart").parents(".ItemDetail").find(".price-detail").html().split(" ")[0];
		var name=$(".addtoCart").parents(".ItemDetail").find(".item-heading").html();
		var imgUrl=$(".addtoCart").parents(".ItemDetail").find(".image-detail img").attr("src");
		var itemID=$(".addtoCart").parents(".ItemDetail").find(".itemID").val();
		var data={"iName":name,"iPrice":price,"iImgUrl":imgUrl,"iItemID":itemID};
		$.ajax({
	        url:'CartItemsServlet',
	        type:'post',
	        data:data,
	        cache:false,
	        success:function(data){
	        	console.log(data);
	        	$(".cart").trigger("click");
	        $(".cartItemsContainer").html(data);
	        $(".CartCount").html($(".cartItem").length);
	        },
	        error:function(){
	         
	        }
	     });
	});
	
	
	
})