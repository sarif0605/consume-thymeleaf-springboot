$("#region-table").DataTable({
  ajax: {
    url: "api/region",
    dataSrc: "",
  },
  columns: [{
      data: "null",
      render: (data, type, row, meta) => {
        return meta.row + 1;
      },
    },
    {
      data: "name"
    },
    {
      data: null,
      render: function (data, type, row, meta) {
        return `
          <button
            type="button"
            class="btn btn-primary"
            data-bs-toggle="modal"
            data-bs-target="#detail"
            onclick="getDetail(${data.id})"
          >
            Detail
          </button>
      `;
      },
    },
  ],
});

function getDetail(id) {
  $.ajax({
    method: "GET",
    url: "api/region/" + id,
    dataType: "JSON",
    contentType: "application/json",
    success: (res) => {
      $("#detail-name").val(res.name);
    },
  });
}

function logout() {
  Swal.fire({
    title: 'Are you sure want to logout this page?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes'
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        method: "POST",
        url: "logout",
        dataType: "JSON",
        beforeSend: addCsrfToken()
      });
      window.location = "http://localhost:8089/login"
    }
  })
}

createRegion = () => {
  let nameVal = $("#create-name").val();

  $.ajax({
    method: "POST",
    url: "api/region",
    dataType: "JSON",
    contentType: "application/json",
    beforeSend: addCsrfToken(),
    data: JSON.stringify({
      name: nameVal,
    }),
    success: (res) => {
      $("#create").modal("hide");
      $("#region-table").DataTable().ajax.reload();
      $("#create-name").val("");
    },
  });
};

/**
 * Tugas: 
 * - Silahkan membuat update & delete untuk Region
 * - Silahkan membuat CRUD Country dengan data table
 */