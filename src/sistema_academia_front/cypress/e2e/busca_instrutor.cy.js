describe('Testes de Instrutor', () => {
   it ('Deve buscar um instrutor', () => {
    cy.visit('/tela_instrutores/index.html');
    cy.get('#search-input').type('Carlos Pereira');
    cy.wait(500);
});
});