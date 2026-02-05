# Scouter Project Rules

## Client Build
- **Always use `./build_client.sh`** to build the Eclipse RCP client (`scouter.client`).
- Do NOT run `mvn` directly under `scouter.client.build/`. The script handles `JAVA_21_HOME` and required `MAVEN_OPTS` settings.