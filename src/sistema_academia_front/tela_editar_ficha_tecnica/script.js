document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("edit-ficha-tecnica-form");

    // Dados fictícios carregados (simula dados vindos de um banco de dados)
    const fichaTecnica = {
        exercicio1: "LegPress",
        categoria1: "Perna",
        exercicio2: "Supino",
        categoria2: "Peito",
        exercicio3: "Pulley",
        categoria3: "Costas"
    };

    // Preenchendo os inputs com os dados existentes
    document.getElementById("exercicio1").value = fichaTecnica.exercicio1;
    document.getElementById("categoria1").value = fichaTecnica.categoria1;
    document.getElementById("exercicio2").value = fichaTecnica.exercicio2;
    document.getElementById("categoria2").value = fichaTecnica.categoria2;
    document.getElementById("exercicio3").value = fichaTecnica.exercicio3;
    document.getElementById("categoria3").value = fichaTecnica.categoria3;

    form.addEventListener("submit", function (event) {
        event.preventDefault();

        // Captura os novos valores
        const updatedFicha = {
            exercicio1: document.getElementById("exercicio1").value,
            categoria1: document.getElementById("categoria1").value,
            exercicio2: document.getElementById("exercicio2").value,
            categoria2: document.getElementById("categoria2").value,
            exercicio3: document.getElementById("exercicio3").value,
            categoria3: document.getElementById("categoria3").value
        };

        console.log("Ficha Técnica Atualizada:", updatedFicha);
        alert("Ficha Técnica atualizada com sucesso!");

        // Aqui você pode salvar os dados em um banco de dados via API
    });
});
