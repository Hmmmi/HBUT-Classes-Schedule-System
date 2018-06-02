
/*      var acnull=false,true       接受空值=不接受，接受
        var val                     所需校验的字符串    
        var type={
		    number_value,           一般数值类型
			number_value[n],        保留n位小数  
			number_tel              电话号码类型
			date,                   时间日期类型
			IP,                     IP地址
			realm,                  域名
			string,                 一般字符串类型
			string[n],              n位字符串
			string[m,n]             m到n位字符串
   }           
                
*/
function InputCheck(val,type,acnull){
        val=val+"";
        if(type.match("number")!=null){
            if(type.match("value")!=null){      //数值判定
	            var digit=(type.match(eval("/[0-9]{1}/"))==null?"":"[\\.]([0-9]{"+type.match(eval("/[0-9]{1}/"))+"})");
	            if(!eval("/([0-9]+)"+digit+"/").test(val)){
	                if(val.match(/([a-zA-Z]+)/)){
	                    //alert("此处不能包含字母!");
	                    return false;
	                }else if((val==null||val=="")&&!acnull){
	                    //alert("此处不能为空!");
	                    return false;
	                }else if(digit!=""&&!eval("/^([0-9]+)"+digit+"$/").test(val)){
	                   // alert("数字请保留"+type.match(eval("/[0-9]{1}/i")+"小数!"));
	                    return false;
	                }else {
	                	return false;
	                } 
	            }   
            }else if(type.match("tel")!=null){  //电话号码判定
            	if((val==null||val=="")&&!acnull){
            		return false;
            	}else if(val.match(/((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/)==null){
            		//alert("请输入正确的电话号码!");
                    return false;
                }  
            }
        }else if(type.match("date")!=null){    //日期判定
        	if((val==null||val=="")&&!acnull){
	            //alertMsg("此处不能为空!");
	            return false;
	        }else if(val.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(10|12|0?[13578])([-\/\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(11|0?[469])([-\/\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(0?2)([-\/\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([3579][26]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][13579][26])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][13579][26])([-\/\._])(0?2)([-\/\._])(29)$))/ig)==null){
	        	return false;
	        }
        }else if(type.match("IP")!=null){
        	if((val==null||val=="")&&!acnull){
	            //alertMsg("此处不能为空!");
	            return false;
	        }else if(val.match(/^((?:(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))\.){3}(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d))))$/)==null){
                //alertMsg("请输入合法的IP地址!");
                return false;
            }
        }else if(type.match("realm")!=null){
        	if((val==null||val=="")&&!acnull){
	            //alertMsg("此处不能为空!");
	            return false;
	        }else if(val.match( /^((https?|ftp|news):\/\/)?([a-z]([a-z0-9\-]*[\.。])+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel)|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))(\/[a-z0-9_\-\.~]+)*(\/([a-z0-9_\-\.]*)(\?[a-z0-9+_\-\.%=&]*)?)?(#[a-z][a-z0-9_]*)?$/)==null){
                //alertMsg("请输入正确的域名!");
                return false;
            } 
        }else if(type.match("string")){
            if((val==null||val=="")&&!acnull){
            	//alertMsg("此处不能为空!");
            	return false;
            }else if(type.match(/string[[0-9]+,[0-9]+]/)!=null){
            	var max=(type.match(/,[0-9]+/)+"").match(/[0-9]+/);
            	var min=type.match(/[0-9]+/);
            	if(val.length>max||val.length<min){
            		//alertMsg("输入字符必须在"+min+"到"+max+"之间!");
            		return false;
            	}
            }else if(type.match(/string[[0-9]+]/)!=null){
            	var count=type.match(/[0-9]+/);
            	if(val.length!=count){
            		//alertMsg("输入的字符数必须为"+count+"!");
            		return false;
            	}
            }
        }else {
        	alertMsg("未知数据类型");
        	return false;
        }
       return true;
    } 