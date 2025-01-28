document.addEventListener("DOMContentLoaded", async function () {
    const alunosGrid = document.getElementById("alunos-grid");
    const modal = document.getElementById("instrutor-modal");
    const closeButton = document.querySelector(".close-button");

    const modalAlunoId = document.getElementById("modal-aluno-id");
    const modalAlunoNome = document.getElementById("modal-aluno-nome");
    const modalAlunoIdade = document.getElementById("modal-aluno-idade");
    const modalAlunoExercicio1 = document.getElementById("modal-aluno-exercicio-1");
    const modalAlunoCategoria1 = document.getElementById("modal-aluno-categoria-1");
    const modalAlunoExercicio2 = document.getElementById("modal-aluno-exercicio-2");
    const modalAlunoCategoria2 = document.getElementById("modal-aluno-categoria-2");
    const modalAlunoExercicio3 = document.getElementById("modal-aluno-exercicio-3");
    const modalAlunoCategoria3 = document.getElementById("modal-aluno-categoria-3");
    const modalAlunoExercicio4 = document.getElementById("modal-aluno-exercicio-4");
    const modalAlunoCategoria4 = document.getElementById("modal-aluno-categoria-4");

    let alunos = []; // Lista de alunos

    // Função para buscar alunos da API
    async function fetchAlunos() {
        try {
            const response = await fetch("http://localhost:8080/alunos");
            if (!response.ok) throw new Error("Erro ao buscar alunos!");
            alunos = await response.json();
            renderAlunos(alunos);
        } catch (error) {
            console.error("Erro ao buscar alunos:", error);
            alert("Erro ao carregar a lista de alunos.");
        }
    }

    // Função para renderizar os alunos no grid
    function renderAlunos(alunosToRender) {
        alunosGrid.innerHTML = "";
        alunosToRender.forEach((aluno) => {
            const alunoItem = document.createElement("div");
            alunoItem.classList.add("grid-item");
            alunoItem.innerHTML = `
                <span class="aluno-name">${aluno.nome}</span>
                <button class="delete-btn" data-id="${aluno.id}">X</button>
            `;

            // Adiciona evento para abrir o modal ao clicar no aluno
            alunoItem.addEventListener("click", function (event) {
                if (event.target.classList.contains("delete-btn")) return;

                modalAlunoId.textContent = aluno.id || "ID não disponível";
                modalAlunoNome.textContent = aluno.nome || "Nome não disponível";
                modalAlunoIdade.textContent = aluno.idade || "Idade não disponível";
                modalAlunoExercicio1.textContent = aluno.exercicio1 || "Exercício 1 não disponível";
                modalAlunoCategoria1.textContent = aluno.categoria1 || "Categoria 1 não disponível";
                modalAlunoExercicio2.textContent = aluno.exercicio2 || "Exercício 2 não disponível";
                modalAlunoCategoria2.textContent = aluno.categoria2 || "Categoria 2 não disponível";
                modalAlunoExercicio3.textContent = aluno.exercicio3 || "Exercício 3 não disponível";
                modalAlunoCategoria3.textContent = aluno.categoria3 || "Categoria 3 não disponível";
                modalAlunoExercicio4.textContent = aluno.exercicio4 || "Exercício 4 não disponível";
                modalAlunoCategoria4.textContent = aluno.categoria4 || "Categoria 4 não disponível";
                modal.style.display = "flex";
            });

            // Adiciona evento para excluir o aluno
            const deleteButton = alunoItem.querySelector(".delete-btn");
            deleteButton.addEventListener("click", async function (event) {
                event.stopPropagation(); // Impede que o clique no botão afete outros eventos
                const id = deleteButton.dataset.id;
                try {
                    const response = await fetch(`http://localhost:8080/alunos/${id}`, {
                        method: "DELETE",
                    });
                    if (!response.ok) throw new Error("Erro ao excluir o aluno!");

                    alert("Aluno excluído com sucesso!");
                    fetchAlunos(); // Atualiza a lista
                } catch (error) {
                    console.error("Erro ao excluir o aluno:", error);
                    alert("Erro ao excluir o aluno. Tente novamente.");
                }
            });
            alunosGrid.appendChild(alunoItem);
        });
    }

    // Fecha o modal ao clicar no botão de fechar
    closeButton.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Fecha o modal ao clicar fora do conteúdo do modal
    window.addEventListener("click", function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });

    // Fecha o modal ao pressionar a tecla "Escape"
    window.addEventListener("keydown", function (event) {
        if (event.key === "Escape") {
            modal.style.display = "none";
        }
    });

    // Filtra alunos pelo termo de busca
    const searchInput = document.getElementById("search-input");
    searchInput.addEventListener("input", function () {
        const searchTerm = searchInput.value.toLowerCase();
        const filteredAlunos = alunos.filter((aluno) =>
            aluno.nome.toLowerCase().includes(searchTerm)
        );
        renderAlunos(filteredAlunos);
    });

    // Carrega os alunos ao iniciar
    fetchAlunos();
});
