function deleteStudents() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Please select students");
        return;
    }
    var ids = "";
    for ( var i = 0; i < items.length; i++) {
        ids += $(items[i]).attr("id");
        if (i < items.length - 1) {
            ids += ",";
        }
    }

    console.log(ids);
    console.log("ids=" + ids);
    var form = '<form id="deleteStudent" action="'
        + context
        + '/admin/studentsList.jsp" method="post"><input type="hidden" name="ids" /></form>';
    $("body").append(form);
    $('#deleteStudent input').val(ids);
    $('#deleteStudent').submit();

}