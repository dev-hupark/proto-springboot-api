const main = {
  init: function() {
    const _this = this;
    $('#btn-save').on('click', () => {
      _this.save();
    });

    $('#btn-update').on('click', () => {
      _this.update();
    });

    $('#btn-delete').on('click', () => {
      _this.delete();
    });
  },
  save: function() {
    let data = {
      todo: $('#todo').val(),
      memo: $('#memo').val()
    }

    $.ajax({
      type: 'POST',
      url: '/api/v1/todos/',
      dataType: 'json',
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(data)
    }).done(() => {
      alert('save todo');
      window.location.href = "/";
    }).fail( error => {
      alert(JSON.stringify(error));
    });
  },
  update: function() {
    let data = {
      todo: $('#todo').val(),
      memo: $('#memo').val()
    }

    const id = $('#id').val();

    $.ajax({
      type: 'PUT',
      url: '/api/v1/todos/'+id,
      dataType: 'json',
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(data)
    }).done(() => {
      alert('update todo');
      window.location.href = "/";
    }).fail( error => {
      alert(JSON.stringify(error));
    });
  },
  delete: function() {
    const id = $('#id').val();

    $.ajax({
      type: 'DELETE',
      url: '/api/v1/todos/'+id,
      dataType: 'json',
      contentType: 'application/json; charset=utf-8',
    }).done(() => {
      alert('delete todo');
      window.location.href = "/";
    }).fail( error => {
      alert(JSON.stringify(error));
    });
  }
}

main.init();