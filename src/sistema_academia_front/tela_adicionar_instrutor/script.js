// Adiciona um instrutor ao enviar o formulário
document.getElementById("add-instrutor-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const form = document.getElementById("add-instrutor-form");
    const formData = new FormData(form);

    const nome = formData.get("nome")?.trim();
    const idade = formData.get("idade")?.trim();
    const salario = formData.get("salario")?.trim();

        if (!nome || !idade || !salario) {
           alert("Todos os campos são obrigatórios!");
            return;
        }

    try {
        const response = await fetch("http://localhost:8080/instrutor", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                nome: nome,
                idade: parseInt(idade, 10),
                salario: parseFloat(salario),
            }),
        });

        if (!response.ok) {
            const errorResponse = await response.text();
            console.error("Erro na resposta da API:", errorResponse);
            throw new Error("Erro ao adicionar o instrutor!");
        }

        alert("Instrutor adicionado com sucesso!");
        form.reset();
        window.location.href = "../tela_instrutores/index.html";
    } catch (error) {
        console.error("Erro ao adicionar o instrutor:", error);
        alert("Ocorreu um erro ao adicionar o instrutor. Tente novamente.");
    }
});
