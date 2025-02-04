document.addEventListener("DOMContentLoaded", async function () {
    const instrutorGrid = document.getElementById("instrutor-grid");
    const modal = document.getElementById("instrutor-modal");
    const closeButton = document.querySelector(".close-button");

    const modalInstrutorId = document.getElementById("modal-instrutor-id");
    const modalInstrutorNome = document.getElementById("modal-instrutor-nome");
    const modalInstrutorFuncao = document.getElementById("modal-instrutor-idade");
    const modalInstrutorSalarioBase = document.getElementById("modal-instrutor-salario-base");

    let instrutores = []; // Lista de instrutores

    // Função para buscar instrutores da API
    async function fetchInstrutores() {
        try {
            const response = await fetch("http://localhost:8080/instrutor");
            if (!response.ok) throw new Error("Erro ao buscar instrutores!");
            instrutores = await response.json();
            renderInstrutores(instrutores);
        } catch (error) {
            console.error("Erro ao buscar instrutores:", error);
            alert("Erro ao carregar a lista de instrutores.");
        }
    }

    // Função para renderizar os instrutores no grid
    function renderInstrutores(instrutoresToRender) {
        instrutorGrid.innerHTML = "";
        instrutoresToRender.forEach((instrutor) => {
            const instrutorItem = document.createElement("div");
            instrutorItem.classList.add("grid-item");

            instrutorItem.innerHTML = `
            <button class="edit-btn" data-id="${instrutor.idInst}">
                ✏️
            </button>
            <span class="instrutor-name">${instrutor.nome}</span>
            <button class="delete-btn" data-id="${instrutor.idInst}">X</button>
        `;

            // Adiciona evento para abrir a página de edição ao clicar no botão de edição
            const editButton = instrutorItem.querySelector(".edit-btn");
            editButton.addEventListener("click", function (event) {
                event.stopPropagation(); // Impede que o clique propague para outros elementos
                window.location.href = `../tela_editar_instrutor/index.html?id=${instrutor.idInst}`;
            });

            // Adiciona evento para excluir o instrutor
            const deleteButton = instrutorItem.querySelector(".delete-btn");
            deleteButton.addEventListener("click", async function (event) {
                event.stopPropagation(); // Impede que o clique no botão afete outros eventos
                const id = deleteButton.dataset.id;
                try {
                    const response = await fetch(`http://localhost:8080/instrutor/${id}`, {
                        method: "DELETE",
                    });
                    if (!response.ok) throw new Error("Erro ao excluir o instrutor!");

                    alert("Instrutor excluído com sucesso!");
                    fetchInstrutores(); // Atualiza a lista
                } catch (error) {
                    console.error("Erro ao excluir o instrutor:", error);
                    alert("Erro ao excluir o instrutor. Tente novamente.");
                }
            });

            instrutorGrid.appendChild(instrutorItem);
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

    // Filtra instrutores pelo termo de busca
    const searchInput = document.getElementById("search-input");
    searchInput.addEventListener("input", function () {
        const searchTerm = searchInput.value.toLowerCase();
        const filteredInstrutores = instrutores.filter((instrutor) =>
            instrutor.nome.toLowerCase().includes(searchTerm)
        );
        renderInstrutores(filteredInstrutores);
    });

    try {
        const response = await fetch("http://localhost:8080/instrutor");
        console.log("Status da resposta:", response.status);
        if (!response.ok) {
            const errorText = await response.text();
            console.error("Erro ao buscar instrutores:", errorText);
            throw new Error("Erro ao buscar instrutores!");
        }
        instrutores = await response.json();
        renderInstrutores(instrutores);
    } catch (error) {
        console.error("Erro ao buscar instrutores:", error);
        alert("Erro ao carregar a lista de instrutores.");
    }



    // Carrega os instrutores ao iniciar
    fetchInstrutores();
});
