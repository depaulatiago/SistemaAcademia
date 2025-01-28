document.addEventListener("DOMContentLoaded", () => {
    console.log("Página inicial carregada.");

    // Função para atualizar a data no footer
    function updateFooterDate() {
        const dateElement = document.getElementById("current-date");
        
        if (dateElement) {
            const today = new Date();
            const formattedDate = `${String(today.getDate()).padStart(2, '0')}/${String(today.getMonth() + 1).padStart(2, '0')}/${today.getFullYear()}`;
            dateElement.textContent = formattedDate;
        }
    }

    // Chamar a função para atualizar a data
    updateFooterDate();
});
