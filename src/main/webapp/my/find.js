
//页面加载完后：
$(function(){

//显示全部书籍	
$.ajax({
    		url:"http://localhost:8080/library/book/find.do",//请求地址
    		type:"post",
			data:"",
			dataType:"json",
			success:function(result){
				if(result.status==200){
					var books=result.data;
					//alert(books);
					for(var i=0;books.length;i++){
						var book_s='';
							book_s+='<tr><td>'+books[i].bno+'</td>';
							book_s+='<td>'+books[i].bname+'</td>';
							book_s+='<td>'+books[i].tid+'</td>';
							book_s+='<td>'+books[i].author+'</td>';
							book_s+='<td>'+books[i].price+'</td>';
							book_s+='<td>'+books[i].total+'</td>';
							book_s+='<td>'+books[i].remain+'</td>';
							book_s+='<td>'+books[i].cdate+'</td>';
							book_s+='<td>';
							book_s+='<button type="button" class="btn btn-xs btn-success" id="btn_detail"  onclick="showDetail(\'' + books[i].id + '\')">查看</button>&nbsp';
							book_s+='<button type="button" class="btn btn-xs btn-warning" id="btn_edit" onclick="showUpdate(\'' + books[i].id + '\')" >修改</button>&nbsp';
							book_s+='<button type="button" class="btn btn-xs btn-danger" id="btn_edit" onclick="showDel(\'' + books[i].id + '\')" >删除</button>';
							book_s+='</td>';
							book_s+='</tr>';
							var $td=$(book_s);
							$("#tbody_td").append($td);
					}
				}
			},
			error:function(){
				window.location.href="static/error/404.html"
			}
    	});
//<!--=======显示查找编号后的书籍======================================================================================-->
//点击查询按钮后
$("#btn_query").click(
		function(){
		//alert("2");
		//获取请求数据
		var bno=$("#query_bno").val();
		var bname=$("#query_bname").val();
		//alert(bno);alert(bname);
		var ko=true;
		if(bno==""){
			//alert("--测试---");
			$("#s").html("亲~请输入编号");
			ko=false;
		}
		if(ko){
			$.ajax({
				url:"http://localhost:8080/library/book/findByBno.do",
				type:"post",
				data:{"bno":bno},
				dataType:"json",
				success:function(result){
					if(result.status==200){
						var books=result.data;
						//alert(books);
						//查找之前先清空之前的书列表
						$("#tbody_td").empty($td);
						
							var book_s='<tr  style="color:red">';
								book_s+='<td>'+books.bno+'</td>';
								book_s+='<td>'+books.bname+'</td>';
								book_s+='<td>'+books.tid+'</td>';
								book_s+='<td>'+books.author+'</td>';
								book_s+='<td>'+books.price+'</td>';
								book_s+='<td>'+books.total+'</td>';
								book_s+='<td>'+books.remain+'</td>';
								book_s+='<td>'+books.cdate+'</td>';
								book_s+='<td>';
								book_s+='<button type="button" class="btn btn-xs btn-success" id="btn_detail">查看</button>&nbsp';
								book_s+='<button type="button" class="btn btn-xs btn-warning" id="btn_edit" >修改</button>&nbsp';
								book_s+='<button type="button" class="btn btn-xs btn-danger" id="btn_edits"  >删除</button>';
								book_s+='</td>';
								book_s+='</tr>';
								var $td=$(book_s);
								$("#tbody_td").append($td);
						
					
					}
				}
				
				
			});
		}
		
		
	});
//<!--=======添加书籍======================================================================================-->
//点击添加按钮后
  $("#btn_add").click(
			
			function() {
				
			 $('#modal_add').modal('show');
			
			 //点击保存的时候
			$("#btn_add_save").click(function(){
				//alert("2");
				var flag = true;

			    var bno = $.trim($("#add_bno").val());
			    if (bno == "") {
			        $("#add_bno").parent().parent().addClass("has-error");
			        $("#add_bno").next().text("请输入图书编码");
			        flag = false;
			    } else if (add_bno.length > 20) {
			        $("#add_bno").parent().parent().addClass("has-error");
			        $("#add_bno").next().text("图书编码长度不能大于20");
			        flag = false;
			    } else {
			        $("#add_bno").parent().parent().removeClass("has-error");
			        $("#add_bno").next().text("");
			    }

			    var add_bname = $.trim($("#add_bname").val());
			    if (add_bname == "") {
			        $("#add_bname").parent().parent().addClass("has-error");
			        $("#add_bname").next().text("请输入图书名称");
			        flag = false;
			    } else if (add_bname.length > 100) {
			        $("#add_bname").parent().parent().addClass("has-error");
			        $("#add_bname").next().text("图书名称长度不能大于100");
			        flag = false;
			    } else {
			        $("#add_bname").parent().parent().removeClass("has-error");
			        $("#add_bname").next().text("");
			    }

			    var add_tid = $.trim($("#add_tid").val());
			    if (add_tid != "") {
			        $("#add_tid").parent().parent().addClass("has-error");
			        $("#add_tid").next().text("请选择图书分类");
			        flag = true;
			    } else {
			        $("#add_tid").parent().parent().removeClass("has-error");
			        $("#add_tid").next().text("");
			    }

			    var add_author = $.trim($("#add_author").val());
			    if (add_author == "") {
			        $("#add_author").parent().parent().addClass("has-error");
			        $("#add_author").next().text("请输入作者");
			        flag = false;
			    } else if (add_author.length > 50) {
			        $("#add_author").parent().parent().addClass("has-error");
			        $("#add_author").next().text("作者长度不能大于50");
			        flag = false;
			    } else {
			        $("#add_author").parent().parent().removeClass("has-error");
			        $("#add_author").next().text("");
			    }

			    var add_price = $.trim($("#add_price").val());
			    if (add_price == "") {
			        $("#add_price").parent().parent().addClass("has-error");
			        $("#add_price").next().text("请输入价格");
			        flag = false;
			    } else if (add_price.length > 6) {
			        $("#add_price").parent().parent().addClass("has-error");
			        $("#add_price").next().text("价格长度不能大于6");
			        flag = false;
			    } else if (!add_price.match(/^[0-9]+(.[0-9]{1,2})?$/)) {
			        $("#add_price").parent().parent().addClass("has-error");
			        $("#add_price").next().text("请输入数字");
			        flag = false;
			    } else {
			        $("#add_price").parent().parent().removeClass("has-error");
			        $("#add_price").next().text("");
			    }

			    var add_total = $.trim($("#add_total").val());
			    if (add_total == "") {
			        $("#add_total").parent().parent().addClass("has-error");
			        $("#add_total").next().text("请输入数量");
			        flag = false;
			    } else if (add_total.length > 4) {
			        $("#add_total").parent().parent().addClass("has-error");
			        $("#add_total").next().text("数量长度不能大于4");
			        flag = false;

			    } else if (!add_total.match(/^(0|[1-9][0-9]*)$/)) {
			        $("#add_total").parent().parent().addClass("has-error");
			        $("#add_total").next().text("请输入数字");
			        flag = false;
			    } else {
			        $("#add_total").parent().parent().removeClass("has-error");
			        $("#add_total").next().text("");
			    }

			    var add_brief = $.trim($("#add_brief").val());
			    if (add_brief.length > 500) {
			        $("#add_brief").parent().parent().addClass("has-error");
			        $("#add_brief").next().text("简介长度不能大于500");
			        flag = false;
			    } else {
			        $("#add_brief").parent().parent().removeClass("has-error");
			        $("#add_brief").next().text("");
			    }
			    var book = {
			            bno: $.trim($("#add_bno").val()),
			            bname: $.trim($("#add_bname").val()),
			            author: $.trim($("#add_author").val()),
			            price: $.trim($("#add_price").val()),
			            total: $.trim($("#add_total").val()),
			            remain: $.trim($("#add_total").val()),
			            brief: $.trim($("#add_brief").val()),
			            tid: $("#add_tid").val()
			        }
			    if(flag){
			    //发送Ajax请求
			    $.ajax({
			    	url:"http://localhost:8080/library/book/save.do",
			    	type:"post",
			    	data:book,
			    	dataType:"json",
			    	success:function(result){
			    		$("#btn_add_save").click(window.location.href="book.html");
			    	},
			    	error:function(){
			    		alert("添加失败，返回重试");
			    	}
			    });//ajax结尾
			    }
			    
			});
		});
//<!--=======查看书籍======================================================================================-->
 
		

});
























