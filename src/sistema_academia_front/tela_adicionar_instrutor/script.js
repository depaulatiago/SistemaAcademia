// Adiciona um instrutor ao enviar o formulário
document.getElementById("add-instrutor-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const form = document.getElementById("add-instrutor-form");
    const formData = new FormData(form);

    const nomeInstrutor = formData.get("nomeInstrutor")?.trim();
    const idade = formData.get("idadeInstrutor")?.trim();
    const salarioBasePlanejado = formData.get("salarioBasePlanejadoInstrutor")?.trim();

    if (!nomeInstrutor || !idade || !salarioBasePlanejado) {
        alert("Todos os campos são obrigatórios!");
        return;
    }

    try {
        // Envia o instrutor para a API
        const response = await fetch("http://localhost:3000/api/instrutores", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                nome: nomeInstrutor,
                idade: parseInt(idade, 10),
                salarioBase: parseFloat(salarioBasePlanejado),
            }),
        });

        if (!response.ok) throw new Error("Erro ao adicionar o instrutor!");

        alert("Instrutor adicionado com sucesso!");
        form.reset();
        window.location.href = "../tela_instrutores/index.html";
    } catch (error) {
        console.error("Erro ao adicionar o instrutor:", error);
        alert("Ocorreu um erro ao adicionar o instrutor. Tente novamente.");
    }
});
