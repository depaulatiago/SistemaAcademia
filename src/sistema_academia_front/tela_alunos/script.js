document.addEventListener("DOMContentLoaded", async function () {
    const alunosGrid = document.getElementById("alunos-grid");
    const modal = document.getElementById("instrutor-modal");
    const closeButton = document.querySelector(".close-button");
    const searchInput = document.getElementById("search-input");

    // Modal fields
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

    let alunos = []; // Lista de fichas

    // Fetch data from /ficha endpoint
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

    // Render alunos in the grid
    function renderAlunos(alunosToRender) {
        alunosGrid.innerHTML = "";
        alunosToRender.forEach((aluno) => {
            const alunoItem = document.createElement("div");
            alunoItem.classList.add("grid-item");
            alunoItem.innerHTML = `
                <span class="aluno-name">${aluno.aluno?.nome}</span>
                <button class="delete-btn" data-id="${aluno.id}">X</button>
            `;

            // Handle modal details display
            alunoItem.addEventListener("click", function (event) {
                if (event.target.classList.contains("delete-btn")) return;

                // Display modal details
                modalAlunoId.textContent = aluno.aluno?.idAluno || "ID não disponível";
                modalAlunoNome.textContent = aluno.aluno?.nome || "Nome não disponível";
                modalAlunoIdade.textContent = aluno.aluno?.idade || "Idade não disponível";

                modalAlunoExercicio1.textContent = aluno.maquinas[0]?.nome || "Exercício 1 não disponível";
                modalAlunoCategoria1.textContent = aluno.maquinas[0]?.categoria || "Categoria 1 não disponível";

                modalAlunoExercicio2.textContent = aluno.maquinas[1]?.nome || "Exercício 2 não disponível";
                modalAlunoCategoria2.textContent = aluno.maquinas[1]?.categoria || "Categoria 2 não disponível";

                modalAlunoExercicio3.textContent = aluno.maquinas[2]?.nome || "Exercício 3 não disponível";
                modalAlunoCategoria3.textContent = aluno.maquinas[2]?.categoria || "Categoria 3 não disponível";

                modalAlunoExercicio4.textContent = aluno.maquinas[3]?.nome || "Exercício 4 não disponível";
                modalAlunoCategoria4.textContent = aluno.maquinas[3]?.categoria || "Categoria 4 não disponível";

                modal.style.display = "flex";
            });

            alunosGrid.appendChild(alunoItem);
        });
    }

    // Close modal events
    closeButton.addEventListener("click", () => (modal.style.display = "none"));
    window.addEventListener("click", (event) => {
        if (event.target === modal) modal.style.display = "none";
    });

    searchInput.addEventListener("input", function () {
        const searchTerm = searchInput.value.toLowerCase();
        const filteredAlunos = alunos.filter((aluno) =>
            aluno.aluno?.nome.toLowerCase().includes(searchTerm)
        );
        renderAlunos(filteredAlunos);
    });

    // Fetch data on load
    fetchAlunos();
});
