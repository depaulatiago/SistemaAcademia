// Obtém os parâmetros da URL para identificar o instrutor
const urlParams = new URLSearchParams(window.location.search);
const instrutorId = urlParams.get("id");

document.addEventListener("DOMContentLoaded", async function () {
    if (instrutorId) {
        await carregarDadosInstrutor(instrutorId);
    }
});

async function carregarDadosInstrutor(id) {
    try {
        const response = await fetch(`http://localhost:8080/instrutor/${id}`);

        if (!response.ok) {
            throw new Error("Instrutor não encontrado!");
        }

        const instrutor = await response.json();

        // Preenche os campos do formulário com os dados existentes
        document.getElementById("id").value = instrutor.idInst;
        document.getElementById("nome").value = instrutor.nome;
        document.getElementById("idade").value = instrutor.idade;
        document.getElementById("salario").value = instrutor.salario;
    } catch (error) {
        console.error("Erro ao buscar os dados do instrutor:", error);
        alert("Erro ao carregar os dados do instrutor!");
    }
}

// Atualiza os dados do instrutor ao submeter o formulário
document.getElementById("add-instrutor-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const form = document.getElementById("add-instrutor-form");
    const formData = new FormData(form);

    const id = formData.get("id")?.trim();
    const nome = formData.get("nome")?.trim();
    const idade = formData.get("idade")?.trim();
    const salario = formData.get("salario")?.trim();

    if (!nome || !idade || !salario) {
        alert("Todos os campos são obrigatórios!");
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/instrutor/${id}`, {
            method: "PUT",
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
            throw new Error("Erro ao editar o instrutor!");
        }

        alert(`Instrutor ${nome} (ID: ${id}) editado com sucesso!`);
        form.reset();
        window.location.href = "../tela_instrutores/index.html";
    } catch (error) {
        console.error("Erro ao editar o instrutor:", error);
        alert("Ocorreu um erro ao editar o instrutor. Tente novamente.");
    }
});
