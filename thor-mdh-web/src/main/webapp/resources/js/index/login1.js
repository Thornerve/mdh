 document.getElementById('submitForm').onclick = function(){

        var userName = $("#userName").val();
		var password = $.trim($('#password').val().replace(/\n/g,"@@@@"));
		
        if(userName == ''){
            return false;
        }
        
        if(password == ''){
            return false;
        }

        var $data = {
            'feedbackType' : feedbackType,
            'question'		: questionValue
        };

	    
    }