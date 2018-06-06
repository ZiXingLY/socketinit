$(function(){
	//页面加载完成之后执行
	pageInit();
});
function pageInit(){
	//创建jqGrid组件
	var c = jQuery("#table_list").jqGrid(
			{
                title : '用户列表',
                url : '/user/getUserListWithPager',
                colNames : [ '主键', '用户名称', '邮箱', '创建时间', '是否有效'],
                colModel : [ {
                    name : 'id',
                    index : 'id',
                    width : 100,
                    key : true
                    // hidden : true
                }, {
                    name : 'nickname',
                    index : 'nickname',
                    width : 100,
                }, {
                    name : 'email',
                    index : 'email',
                    width : 100,
                }, {
                    name : 'createTime',
                    index : 'createTime',
                    width : 100,
                }, {
                    name : 'status',
                    index : 'status',
                    width : 100,
                } ],
                jsonReader : {
                    root : "list",
                    total : "pages",
                    records : "total",
                    page : "pageNum",
                    rowNum : "pageSize"
                },
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				rowNum : 10,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#pager_list',//表格页脚的占位符(一般是div)的id
				sortname : 'id',//初始化的时候排序的字段
				sortorder : "desc",//排序方式,可选desc,asc
				mtype : "post",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				caption : "JSON Example",//表格的标题名字
                onPaging : function(){
					console.log(c.getGridParam().postData);
				}
			});
	// console.log(c.getGridParam());

	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#pager_list").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false});
}