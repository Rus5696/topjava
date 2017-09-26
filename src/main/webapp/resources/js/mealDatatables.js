var ajaxUrl = "ajax/profile/meals/";
var datatableApi;

function updateTable() {
  $.ajax({
    type: "POST",
    url: ajaxUrl + "filter",
    data: $("#filter").serialize(),
    success: updateTableByData
  });
}

function clearFilter() {
  $("#filter")[0].reset();
  $.get(ajaxUrl, updateTableByData);
}

$(function () {
  // var startDate =  $('#startDate');
  // var startTime =  $('#startTime').datetimepicker();
  // startDate.datetimepicker({
  //   timepicker: false,
  //   format: 'Y-m-d',
  //   formatDate: 'Y-m-d'
  // });
  datatableApi = $("#datatable").DataTable({
    "ajax": {
      "url": ajaxUrl,
      "dataSrc": ""
    },
    "paging": false,
    "info": true,
    "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
      if (aData["exceed"]) {
        $('td', nRow).toggleClass("exceeded")
      } else {
        $('td', nRow).toggleClass("normal")
      }
    },
    "columns": [
      {
        "data": "dateTime",
        "render": function (date, type, row) {
          if (type === "display") {
            return date.substring(0, 10) + date.substring(11, date.length);
          }
          return date;
        }
      },
      {
        "data": "description"
      },
      {
        "data": "calories"
      },
      {
        "orderable": false,
        "defaultContent": "",
        "render": renderEditBtn
      },
      {
        "orderable": false,
        "defaultContent": "",
        "render": renderDeleteBtn
      }
    ],
    "order": [
      [
        0,
        "desc"
      ]
    ]
  });
  makeEditable();
});