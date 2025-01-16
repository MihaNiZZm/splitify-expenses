-- Table: payment_details, removing PRIMARY KEY
ALTER TABLE main.payment_details
DROP CONSTRAINT payment_details_pkey;

-- Table: payment_details, creating id column
ALTER TABLE main.payment_details
ADD id UUID;

-- Table: payment_details, setting new PRIMARY KEY to id column
ALTER TABLE main.payment_details
ADD PRIMARY KEY (id);


