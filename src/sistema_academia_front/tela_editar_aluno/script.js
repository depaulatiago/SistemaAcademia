// Obtém os parâmetros da URL para identificar o aluno
const urlParams = new URLSearchParams(window.location.search);
const alunoId = urlParams.get("id");

document.addEventListener("DOMContentLoaded", async function () {
    if (alunoId) {
        await carregarDadosAluno(alunoId);
    }
});

async function carregarDadosAluno(id) {
    try {
        const response = await fetch(`http://localhost:8080/ficha/${id}`);

        if (!response.ok) {
            throw new Error("Aluno não encontrado!");
        }

        const aluno = await response.json();

        // Preenche os campos do formulário com os dados existentes
        document.getElementById("id").value = aluno.id;
        document.getElementById("nome").value = aluno.aluno?.nome;
        document.getElementById("idade").value = aluno.aluno?.idade;
        document.getElementById("exercicio1").value = aluno.maquinas[0]?.nome || "";
        document.getElementById("categoria1").value = aluno.maquinas[0]?.categoria || "";
        document.getElementById("exercicio2").value = aluno.maquinas[1]?.nome || "";
        document.getElementById("categoria2").value = aluno.maquinas[1]?.categoria || "";
    } catch (error) {
        console.error("Erro ao buscar os dados do aluno:", error);
        alert("Erro ao carregar os dados do aluno!");
    }
}

// Atualiza os dados do aluno ao submeter o formulário
document.getElementById("edit-aluno-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const form = document.getElementById("edit-aluno-form");
    const formData = new FormData(form);

    const id = formData.get("id")?.trim();
    const nome = formData.get("nome")?.trim();
    const idade = formData.get("idade")?.trim();
    const exercicio1 = formData.get("exercicio1")?.trim();
    const categoria1 = formData.get("categoria1")?.trim();
    const exercicio2 = formData.get("exercicio2")?.trim();
    const categoria2 = formData.get("categoria2")?.trim();

    if (!nome || !idade || !exercicio1 || !categoria1 || !exercicio2 || !categoria2) {
        alert("Todos os campos são obrigatórios!");
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/ficha/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                aluno: { nome: nome, idade: parseInt(idade, 10) },
                maquinas: [
                    { nome: exercicio1, categoria: categoria1 },
                    { nome: exercicio2, categoria: categoria2 }
                ]
            }),
        });

        if (!response.ok) {
            const errorResponse = await response.text();
            console.error("Erro na resposta da API:", errorResponse);
            throw new Error("Erro ao editar o aluno!");
        }

        alert(`Aluno ${nome} (ID: ${id}) editado com sucesso!`);
        form.reset();
        window.location.href = "../tela_alunos/index.html";
    } catch (error) {
        console.error("Erro ao editar o aluno:", error);
        alert("Ocorreu um erro ao editar o aluno. Tente novamente.");
    }
});
