(function () {

    function Contatos(nome, email, telefone, mensagem) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.mensagem = mensagem;
    }

    function contatoControler() {
        
        function _save() {
        	var cadastroSerializado = $('form[rule=cadastro]').serialize();
        	$.post('api/contatos', cadastroSerializado, function (data, status) {
                if(status ==="success"){
                	alert("Dados salvos com sucesso!");
               }else{
                	alert("Problema ao gravar dados!");
                }
                
            });
        }
      
        return {
            save: _save
        }
    }

    $(function () {
    	window.ctrl = contatoControler();
        $('#btnSalvar').click(function () {
            ctrl.save();
        });
    });

})();