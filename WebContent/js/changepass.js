$(function(){
	
	 
	//获取当前用户的信息	
	function getmessage(){
		$.post("/user/hnGetValue",function(data){
			$("#account").text(data.name);
			$("#etcLowValue").val(data.EtcLowValue);
			$("#ethLowValue").val(data.EthLowValue);
			$("#ltcLowValue").val(data.LtcLowValue);
			$("#etcHighValue").val(data.EtcHighValue);
			$("#ethHighValue").val(data.EthHighValue);
			$("#ltcHighValue").val(data.LtcHighValue);
		},'json');
	}
	getmessage();
	
	function getprice(){
		$.getJSON("/getPrice", function(data){
			 $("#etcprice").text(data.etcPrice);
			 $("#ltcprice").text(data.ltcPrice);
			 $("#ethprice").text(data.ethPrice);
			});
	}
	getprice();
	setInterval(getprice,3000);// 注意函数名没有引号和括弧！ 
	   //修改密码的函数
		var oldpass,newpass,renewpass;
		$("#sure").click(function(){
			etcLowValue=$.trim($("#etcLowValue").val())
			ethLowValue=$.trim($("#ethLowValue").val())
			ltcLowValue=$.trim($("#ltcLowValue").val())
			etcHighValue=$.trim($("#etcHighValue").val())
			ethHighValue=$.trim($("#ethHighValue").val())
			ltcHighValue=$.trim($("#ltcHighValue").val())
		
				
			$.post("/user/hnChangeValue",{
				etcLowValue:etcLowValue,
				ethLowValue:ethLowValue,
				ltcLowValue:ltcLowValue,
				etcHighValue:etcHighValue,
				ethHighValue:ethHighValue,
				ltcHighValue:ltcHighValue
				
				},function(data){
				if(data.result){
					alert("修改预警值成功！");
				}else{
					alert(data.error);
					return;
				}
			},"json");
			
			
		})
		
	
})





	
	
