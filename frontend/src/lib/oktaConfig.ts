export const oktaConfig = {
    clientId: '<CLIENTID HERE>',
    issuer: 'https://dev-48382148.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
}