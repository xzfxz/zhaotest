			var code ; //��ȫ�ֶ�����֤�� 
			//������֤��
			window.onload = function createCode(){
				 code = ""; 
				 var codeLength = 4;//��֤��ĳ���
				 var checkCode = document.getElementById("code"); 
				 var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
				 'S','T','U','V','W','X','Y','Z');//�����
				 for(var i = 0; i < codeLength; i++) {//ѭ������
					var index = Math.floor(Math.random()*36);//ȡ���������������0~35��
					code += random[index];//��������ȡ��������ӵ�code��
				}
				checkCode.value = code;//��codeֵ������֤��
			};
			//У����֤��
			function validate(){
				var inputCode = document.getElementById("input").value.toUpperCase(); //ȡ���������֤�벢ת��Ϊ��д      
				if(inputCode.length <= 0) { //���������֤�볤��Ϊ0
					alert("��������֤�룡"); //�򵯳���������֤��
				}       
				else if(inputCode != code ) { //���������֤�����������֤�벻һ��ʱ
					alert("��֤���������@_@"); //�򵯳���֤���������
					createCode();//ˢ����֤��
					document.getElementById("input").value = "";//����ı���
				}       
				else { //������ȷʱ
					alert("^-^"); //����^-^
				}           
			};
			function createCode1(){
				 code = ""; 
				 var codeLength = 4;//��֤��ĳ���
				 var checkCode = document.getElementById("code"); 
				 var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
				 'S','T','U','V','W','X','Y','Z');//�����
				 for(var i = 0; i < codeLength; i++) {//ѭ������
					var index = Math.floor(Math.random()*36);//ȡ���������������0~35��
					code += random[index];//��������ȡ��������ӵ�code��
				}
				checkCode.value = code;//��codeֵ������֤��
			}