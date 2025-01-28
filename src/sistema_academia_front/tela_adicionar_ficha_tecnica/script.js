document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("ficha-tecnica-form");
    
    form.addEventListener("submit", function (event) {
        event.preventDefault();
        
        // Obter valores dos inputs
        const exercicios = [];
        const categorias = [];
        
        for (let i = 1; i <= 4; i++) {
            const exercicio = document.getElementById(`exercicio${i}`).value.trim();
            const categoria = document.getElementById(`categoria${i}`).value.trim();
            
            if (exercicio && categoria) {
                exercicios.push(exercicio);
                categorias.push(categoria);
            }
        }
        
        // Exibir os valores no console (pode ser ajustado para salvar em banco de dados ou exibir na página)
        console.log("Exercícios:", exercicios);
        console.log("Categorias:", categorias);
        
        alert("Ficha técnica salva com sucesso!");
        
        // Limpar o formulário
        form.reset();
    });
});
