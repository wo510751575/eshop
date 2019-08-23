//编辑器
if(typeof(KindEditor) != "undefined") {
	KindEditor.ready(function(K) {
		editor = K.create("#editor", {
			height: "350px",
			items: [
				"source", "|", "undo", "redo", "|", "preview", "print", "template", "cut", "copy", "paste",
				"plainpaste", "wordpaste", "|", "justifyleft", "justifycenter", "justifyright",
				"justifyfull", "insertorderedlist", "insertunorderedlist", "indent", "outdent", "subscript",
				"superscript", "clearhtml", "quickformat", "selectall", "|", "fullscreen", "/",
				"formatblock", "fontname", "fontsize", "|", "forecolor", "hilitecolor", "bold",
				"italic", "underline", "strikethrough", "lineheight", "removeformat", "|", "image","multiimage",
				"flash", "media",  "table", "hr", "emoticons", "baidumap", "pagebreak",
				"anchor", "link", "unlink"
			],
			langType: "zh_CN",
			syncType: "form",
			filterMode: false,
			pagebreakHtml: '<hr class="pageBreak" \/>',
			allowFileManager: true,
			filePostName: "file",
			uploadJson:ctx+"/file/upload?dirName=editor",
			uploadImageExtension: "jpg,jpeg,gif,png",
			uploadFlashExtension: "swf,flv",
			uploadMediaExtension: "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb",
			uploadFileExtension: "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2",
			afterChange: function() {
				this.sync();
			}
		});
	});
}