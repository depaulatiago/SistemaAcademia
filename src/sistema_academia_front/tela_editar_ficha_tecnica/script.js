// Obtém os parâmetros da URL para identificar a ficha técnica
const urlParams = new URLSearchParams(window.location.search);
const fichaId = urlParams.get("id");

document.addEventListener("DOMContentLoaded", async function () {
    if (fichaId) {
        await carregarDadosFicha(fichaId);
    }
});

// Atualiza os dados da ficha técnica ao submeter o formulário
document.getElementById("edit-ficha-tecnica-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const form = document.getElementById("edit-ficha-tecnica-form");
    const formData = new FormData(form);

    const id = formData.get("ficha-id")?.trim();
    const idAluno = formData.get("id-aluno")?.trim();
    const idInstrutor = formData.get("id-instrutor")?.trim();
    const idsMaquinas = formData.get("ids-maquinas")
        .split(",") // Divide os IDs por vírgula
        .map(id => id.trim()) // Remove espaços extras
        .map(Number); // Converte para números

    if (!idAluno || !idInstrutor || idsMaquinas.length === 0) {
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
                aluno: { id: idAluno }, // Ajustado para a estrutura correta
                instrutor: { id: idInstrutor }, // Ajustado para a estrutura correta
                maquinas: idsMaquinas.map(id => ({ id })) // Ajustado para enviar os IDs das máquinas como objetos
            }),
        });

        if (!response.ok) {
            const errorResponse = await response.text();
            console.error("Erro na resposta da API:", errorResponse);
            throw new Error("Erro ao editar a ficha técnica!");
        }

        alert(`Ficha Técnica (ID: ${id}) editada com sucesso!`);
        form.reset();
        window.location.href = "../tela_fichas_tecnicas/index.html";
    } catch (error) {
        console.error("Erro ao editar a ficha técnica:", error);
        alert("Ocorreu um erro ao editar a ficha técnica. Tente novamente.");
    }
});
