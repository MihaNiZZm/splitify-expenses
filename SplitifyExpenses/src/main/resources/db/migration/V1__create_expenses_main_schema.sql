-- Create schema
CREATE SCHEMA IF NOT EXISTS main;

-- Table: users
CREATE TABLE main.users (
    id UUID PRIMARY KEY,
    email VARCHAR(320) UNIQUE,
    phone_number VARCHAR(16) UNIQUE,
    first_name VARCHAR(64),
    middle_name VARCHAR(64),
    last_name VARCHAR(64),
    nickname VARCHAR(64) UNIQUE
);

-- Table: currencies
CREATE TABLE main.currencies (
    id SERIAL PRIMARY KEY,
    code VARCHAR(8) NOT NULL,
    symbol VARCHAR(2),
    name VARCHAR(64) NOT NULL
);

-- Table: events
CREATE TABLE main.events (
    id UUID PRIMARY KEY,
    creator_id UUID NOT NULL REFERENCES main.users (id),
    name VARCHAR(256) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    ended_at TIMESTAMP
);

-- Table: expenses
CREATE TABLE main.expenses (
    id UUID PRIMARY KEY,
    payer_id UUID NOT NULL REFERENCES main.users (id),
    currency_id INT NOT NULL REFERENCES main.currencies (id),
    event_id UUID NOT NULL REFERENCES main.events (id),
    amount DECIMAL NOT NULL,
    name VARCHAR(128) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL
);

-- Table: expenses_shares
CREATE TABLE main.expenses_shares (
    participant_id UUID NOT NULL REFERENCES main.users (id),
    paid_by_id UUID NOT NULL REFERENCES main.users (id),
    amount_to_pay DECIMAL NOT NULL,
    expense_id UUID NOT NULL REFERENCES main.expenses (id),
    PRIMARY KEY (expense_id, participant_id)
);

-- Table: payment_details
CREATE TABLE main.payment_details (
    user_id UUID PRIMARY KEY REFERENCES main.users (id),
    currency_id INT REFERENCES main.currencies (id),
    name VARCHAR(128) NOT NULL,
    description TEXT,
    is_primary BOOLEAN NOT NULL
);

-- Table: events_participants
CREATE TABLE main.events_participants (
    user_id UUID NOT NULL REFERENCES main.users (id),
    event_id UUID NOT NULL REFERENCES main.events (id),
    event_nickname VARCHAR(64),
    PRIMARY KEY (user_id, event_id)
);

-- Table: user_preferences
CREATE TABLE main.user_preferences (
    user_id UUID PRIMARY KEY REFERENCES main.users (id),
    theme VARCHAR(32),
    locale VARCHAR(16),
    currency_by_default_id INT REFERENCES main.currencies (id)
);

-- Table: audit_expenses
CREATE TABLE main.audit_expenses (
    id UUID PRIMARY KEY,
    expense_id UUID NOT NULL REFERENCES main.expenses (id),
    changed_by_id UUID NOT NULL REFERENCES main.users (id),
    change_type VARCHAR(32) NOT NULL,
    change_data JSONB NOT NULL,
    changed_at TIMESTAMP NOT NULL
);

-- Table: event_invitations
CREATE TABLE main.event_invitations (
    id UUID PRIMARY KEY,
    token VARCHAR(64) UNIQUE NOT NULL,
    status VARCHAR(32) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    expires_at TIMESTAMP,
    created_by UUID NOT NULL REFERENCES main.users (id),
    event_id UUID NOT NULL REFERENCES main.events (id),
    max_amount_of_users INT
);

-- Table: audit_events
CREATE TABLE main.audit_events (
    id UUID PRIMARY KEY,
    event_id UUID NOT NULL REFERENCES main.events (id),
    changed_by_id UUID NOT NULL REFERENCES main.users (id),
    change_type VARCHAR(32) NOT NULL,
    change_data JSONB NOT NULL,
    changed_at TIMESTAMP NOT NULL
);

-- Suggested indexes
CREATE INDEX idx_event_creator ON main.events (creator_id);
CREATE INDEX idx_expenses_event_id ON main.expenses (event_id);
CREATE INDEX idx_expenses_payer_id ON main.expenses (payer_id);
CREATE INDEX idx_expenses_currency_id ON main.expenses (currency_id);
CREATE INDEX idx_invitation_event_id ON main.event_invitations (event_id);
CREATE INDEX idx_participants_event_id ON main.events_participants (event_id);
