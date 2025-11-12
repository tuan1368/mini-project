# Multi-arch friendly PostGIS image built from the official postgres base (supports arm64/amd64)
# Uses Postgres 15 and installs PostGIS 3 packages.
FROM postgres:15

# Install PostGIS
RUN apt-get update \
    && apt-get install -y --no-install-recommends \
       postgresql-15-postgis-3 \
       postgresql-15-postgis-3-scripts \
    && rm -rf /var/lib/apt/lists/*

# (Optional) You can add extensions automatically by placing SQL in /docker-entrypoint-initdb.d
# Example (uncomment to use):
# COPY enable-postgis.sql /docker-entrypoint-initdb.d/10_enable_postgis.sql

# Expose default Postgres port
EXPOSE 5432

