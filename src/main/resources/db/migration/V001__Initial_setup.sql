CREATE TABLE IF NOT EXISTS proposal (
    id BIGSERIAL PRIMARY KEY,
    external_id UUID UNIQUE NOT NULL,
    identity_document VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL NOT NULL,
    street VARCHAR(100) NOT NULL,
    streetNumber VARCHAR(100) NOT NULL,
    secondaryAddress VARCHAR(100),
    city VARCHAR(100) NOT NULL,
    state VARCHAR(2) NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT NOW(),
    updated TIMESTAMP NOT NULL DEFAULT NOW()
);
