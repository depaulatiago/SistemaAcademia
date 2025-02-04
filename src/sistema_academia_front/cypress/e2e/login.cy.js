describe('Testes de Usuario', () => {
  it('Deve realizar login', () => {
      cy.visit('/tela_login/index.html');
      cy.get('#email').type('admin@example.com');
      cy.get('#senha').type('admin123');
      cy.get('button[type=submit]').click();
      cy.contains('Login bem-sucedido!');
  });
});