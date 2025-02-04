describe('Testes de Instrutor', () => {
    it('Deve cadastrar um novo instrutor', () => {
        cy.visit('/tela_adicionar_instrutor/index.html');
        cy.get('#nome').type('Carlos Pereira');
        cy.get('#idade').type('40');
        cy.get('#salario').type('3000');
        cy.get('button[type=submit]').click();
    });
});
