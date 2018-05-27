$(document).ready(function() {
    var table = $("#table");
    table.on('click', '.delete', function () {
        var button = $(this);
        $.ajax({
            url: $(this).next('input').attr('value'),
            type: 'DELETE',
            success: function(result) {
                button.closest('tr').remove();
            }
        });
    });
});