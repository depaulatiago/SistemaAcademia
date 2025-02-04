document.addEventListener("DOMContentLoaded", async function () {
    const alunosGrid = document.getElementById("alunos-grid");
    const modal = document.getElementById("instrutor-modal");
    const closeButton = document.querySelector(".close-button");
    const searchInput = document.getElementById("search-input");

    let alunos = []; // Lista de alunos

    // Fetch dados dos alunos
    async function fetchAlunos() {
        try {
            const response = await fetch("http://localhost:8080/ficha");
            if (!response.ok) throw new Error("Erro ao buscar dados!");
            alunos = await response.json();
            renderAlunos(alunos);
        } catch (error) {
            console.error("Erro ao buscar dados:", error);
            alert("Erro ao carregar a lista.");
        }
    }

    // Renderiza os alunos no grid
    function renderAlunos(alunosToRender) {
        alunosGrid.innerHTML = "";
        alunosToRender.forEach((aluno) => {
            const alunoItem = document.createElement("div");
            alunoItem.classList.add("grid-item");

            alunoItem.innerHTML = `
                <button class="edit-btn" data-id="${aluno.id}">✏️</button>
                <span class="aluno-name">${aluno.aluno?.nome}</span>
                <button class="delete-btn" data-id="${aluno.id}">X</button>
            `;

            // Botão de edição - leva para a página de edição passando o ID
            const editButton = alunoItem.querySelector(".edit-btn");
            editButton.addEventListener("click", function (event) {
                event.stopPropagation(); // Impede propagação do clique
                window.location.href = `../tela_editar_aluno/index.html?id=${aluno.id}`;
            });

            // Botão de exclusão
            const deleteButton = alunoItem.querySelector(".delete-btn");
            deleteButton.addEventListener("click", async function (event) {
                event.stopPropagation(); // Impede que o clique afete outros eventos
                const id = deleteButton.dataset.id;
                try {
                    const response = await fetch(`http://localhost:8080/ficha/${id}`, {
                        method: "DELETE",
                    });
                    if (!response.ok) throw new Error("Erro ao excluir!");

                    alert("Aluno excluído com sucesso!");
                    fetchAlunos(); // Atualiza a lista
                } catch (error) {
                    console.error("Erro ao excluir:", error);
                    alert("Erro ao excluir. Tente novamente.");
                }
            });

            alunosGrid.appendChild(alunoItem);
        });
    }

    // Fecha o modal ao clicar no botão de fechar
    closeButton.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Fecha o modal ao clicar fora do conteúdo
    window.addEventListener("click", function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });

    // Filtro de busca
    searchInput.addEventListener("input", function () {
        const searchTerm = searchInput.value.toLowerCase();
        const filteredAlunos = alunos.filter((aluno) =>
            aluno.aluno?.nome.toLowerCase().includes(searchTerm)
        );
        renderAlunos(filteredAlunos);
    });

    fetchAlunos(); // Carrega os alunos ao iniciar
});
