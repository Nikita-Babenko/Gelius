
// this code for calendar
// see https://eonasdan.github.io/bootstrap-datetimepicker/

$(function () {
    $('#datetimepicker1').datetimepicker();
});

$( document ).ready(function() {
   customerSelect();
});

function customerSelect() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/clients/all",
        data: "",
        dataType: 'json',
        timeout: 100000,
        success: function (clients) {

           $($.parseJSON(clients.result)).map(function () {
                return $('<option>').val(this.value).text(this.label);
            }).appendTo('#customer');

        },
        error: function (e) {
            console.log("ERROR: ", e);
        }
    });
}