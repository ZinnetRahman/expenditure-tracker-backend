-- Database: expenditure

-- DROP DATABASE IF EXISTS expenditure;

CREATE DATABASE expenditure
    WITH
--     OWNER = zinnet
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
-----------------------------------------------------

    -- Table: public.expense

-- DROP TABLE IF EXISTS public.expense;

CREATE TABLE IF NOT EXISTS public.expense
(
    id bigint NOT NULL,
    amount character varying(255) COLLATE pg_catalog."default",
    expense_date timestamp with time zone,
                               file_name character varying(255) COLLATE pg_catalog."default",
    item_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT expense_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

