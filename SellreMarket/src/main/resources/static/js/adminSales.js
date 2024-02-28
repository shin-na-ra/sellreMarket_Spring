
window.onload=function(){
	init();
}	
	
function init() {
	sales();
	popular();
	gender();
	user();
	
}


// 매출현황 데이터 조회
function sales() {
	
	$.ajax({
		type : "POST",
		url : "showSaleChart",
		success : function(list){
			let chart = new Chart(document.getElementById("chartContainer"), {
				
				type: 'line',
			   		options: {
			   			responsive: false,
			      		title: {
			        		text: "매출현황"
			      		},
			      		axisX: {
			       			title: "날짜",
				        	gridThickness: 2
				     	},
			     		axisY: {
			        		title: "금액(원)"
			      		},
			    	},
			    	
			    	data: {
			    		labels : [
			    			
			   				  list[0].purchasedate,
			   				  list[1].purchasedate,
			   				  list[2].purchasedate,
			   				  list[3].purchasedate,
			   				  list[4].purchasedate,
			   				  list[5].purchasedate,
			   				  list[6].purchasedate
			   				  
			    		],
			    		datasets: [{
				    		label : '매출(원)',
				    		data : [
				    			
				    			list[0].total,
				    			list[1].total,
				    			list[2].total,
				    			list[3].total,
				    			list[4].total,
				    			list[5].total,
				    			list[6].total
				    			
				    		],
				    		borderColor: "rgba(255, 201, 14, 1)",
				            backgroundColor: "rgba(255, 201, 14, 0.5)",
				            hoverBorderColor : "rgba(255, 189, 14, 0.5)",
				            fill: false,
				            lineTension: 0
				    	}]
			   		} 
			    
		 		});
			  chart.render();
		},
		 error:function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

// 이 달 인기제품 top 5 가져오기
function popular() {
	
	$.ajax({
		type : "POST",
		url : "showPopular",
		success : function(list){
			let chart = new Chart(document.getElementById("donutContainer"), {
				
			  	type: 'doughnut',
		   		options: {
		   			responsive: false
		      		
		    	},
		    	
		    	data: {
		    		labels : [
		    			
		   				  list[0].name,
		   				  list[1].name,
		   				  list[2].name,
		   				  list[3].name,
		   				  list[4].name
		    		],
		    		
		    		datasets: [{
			    		label : '이 달 인기 제품 TOP5',
			    		backgroundColor: ["#E5756E", "#F6C97C","#FAE594","#A2DB89","#90B9F8"],
			    		data : [
			    			
			    			list[0].amount,
			    			list[1].amount,
			    			list[2].amount,
			    			list[3].amount,
			    			list[4].amount
			    			
			    		],
			    	}]
		   		} 
	 		});
		  chart.render();
		},
		 error:function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}


//가입 성비 조회
function gender() {
	
	$.ajax({
		type : "POST",
		url : "showGender",
		success : function(list){
			let chart = new Chart(document.getElementById("pieContainer"), {
				
			  	type: 'pie',
		   		options: {
		   			responsive: false
		      		
		    	},
		    	
		    	data: {
		    		labels : [
		    			
		   				  list[0].name,
		   				  list[1].name,
		   				  list[2].name,
		    		],
		    		
		    		datasets: [{
			    		label : '이 달 인기 제품 TOP5',
			    		backgroundColor: ["#EB6D85","#58A0E5","#F7CE6B"],
			    		data : [
			    			
			    			list[0].genderCnt,
			    			list[1].genderCnt,
			    			list[2].genderCnt
			    			
			    		],
			    	}]
		   		} 
	 		});
		  chart.render();
		},
		 error:function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}


//많이 주문한 고객 
function user() {
	
	$.ajax({
		type : "POST",
		url : "showUser",
		success : function(list){
			let chart = new Chart(document.getElementById("horiContainer"), {
				
			  	type: 'bar',
		   		options: {
		   			responsive: false
		      		
		    	},
		    	
		    	data: {
		    		labels : [
		    			
		   				  list[0].userid +"["+list[0].name+"]",
		   				  list[1].userid +"["+list[1].name+"]",
		   				  list[2].userid +"["+list[2].name+"]",
		   				  list[3].userid +"["+list[3].name+"]",
		   				  list[4].userid +"["+list[4].name+"]"
		    		],
		    		
		    		datasets: [{
			    		label : '이 달 인기 제품 TOP5',
			    		backgroundColor: ["#E5756E", "#F6C97C","#FAE594","#A2DB89","#90B9F8"],
			    		data : [
			    			
			    			list[0].purCnt,
			    			list[1].purCnt,
			    			list[2].purCnt,
			    			list[3].purCnt,
			    			list[4].purCnt
			    		],
			    	}]
		   		} 
			});
		  	chart.render();
		},
		 error:function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}