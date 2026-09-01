# DigiPet Care

MVP do backend para gestão multi-tenant de clínicas e petshops, conforme o documento de system design recebido.

## Executar

Defina `DB_PASSWORD` e inicie o PostgreSQL: `docker compose up -d`. Em seguida execute `./mvnw spring-boot:run` (Windows: `mvnw.cmd spring-boot:run`). O Flyway cria o schema automaticamente.

## Agendamentos

- `GET /api/v1/clinicas/{clinicaId}/agendamentos`
- `POST /api/v1/clinicas/{clinicaId}/agendamentos`

Exemplo de corpo:

```json
{"petId": 1, "servicoId": 1, "profissionalId": 1, "dataHora": "2026-09-02T10:00:00", "observacoes": "Primeira consulta"}
```

O serviço valida tenant, pet, serviço ativo, profissional habilitado, escala e sobreposição de horários. A rota por clínica é provisória: antes de produção, o `clinicaId` deve ser obtido do JWT, conforme o desenho de segurança do projeto.
