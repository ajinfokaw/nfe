// Estrutura da chave de acesso:
// UF: 2 dígitos
// AAMM: 4 dígitos
// CNPJ: 14 dígitos
// Modelo: 2 dígitos
// Série: 3 dígitos
// Número: 9 dígitos
// Tipo Emissão: 1 dígito
// Código Randômico: 8 dígitos
// Total: 2+4+14+2+3+9+1+8 = 43 dígitos (sem DV)
// Com DV: 44 dígitos

// Se está gerando 45 dígitos, algum campo tem 1 dígito a mais.
// Possíveis causas:
// 1. Modelo retornando 3 dígitos ao invés de 2
// 2. Série retornando 4 dígitos ao invés de 3
// 3. Tipo de emissão retornando 2 dígitos ao invés de 1
