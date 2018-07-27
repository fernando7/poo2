$(document).ready(function() {
  $(document).on('submit','#form-cadastro-raca',function(){
        $.ajax({
        url: $("#form-cadastro-raca").attr("action"),
          type: $("#form-cadastro-raca").attr("method"),
          data: $("#form-cadastro-raca").serialize(),
          success: function(data) {
            $('#modal-cadastro-raca').modal('toggle');
            $(".racas").html(data);
          }

        });

        return false;
  });
});