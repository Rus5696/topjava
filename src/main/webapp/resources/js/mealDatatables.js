var ajaxUrl = "/rest/profile/meals/";
var datatableApi;
var formId = "#detailsFormUsers";
var editRowId = "#editRowUser";

// $(document).ready(function () {
$(function () {
  datatableApi = $("#datatableMeals").DataTable({
    "paging": false,
    "info": true,
    "columns": [
      {
        "data": "dateTime"
      },
      {
        "data": "description"
      },
      {
        "data": "calories"
      },
      {
        "defaultContent": "Edit",
        "orderable": false
      },
      {
        "defaultContent": "Delete",
        "orderable": false
      }
    ],
    "order": [
      [
        0,
        "asc"
      ]
    ]
  });
  makeEditable();
});