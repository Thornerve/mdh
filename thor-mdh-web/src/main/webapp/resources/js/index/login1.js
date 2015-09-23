   /**
    * 登陆校验
    */
  	$('#submitForm').on('click',function(){
  		
        var userName = $.trim($("#userName").val());
		var password = $.trim($('#password').val());
		
		console.log(userName + "----" + password)
		
        if(userName == '' || userName == null){
        	$('#userName').attr('placeholder','请输入用户名');
            return false;
        }
        
        if(password == '' || password == null){
        	$('#password').attr('placeholder','请输入密码');
            return false;
        }
	    
    });
 