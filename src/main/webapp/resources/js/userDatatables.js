var ajaxUrl = "ajax/admin/users/";
var datatableApi;
var formId = "#detailsFormUsers"
var editRowId = "#editRowUsers"

// $(document).ready(function () {
$(function () {
  datatableApi = $("#datatableUsers").DataTable({
    "paging": false,
    "info": true,
    "columns": [
      {
        "data": "name"
      },
      {
        "data": "email"
      },
      {
        "data": "roles"
      },
      {
        "data": "enabled"
      },
      {
        "data": "registered"
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