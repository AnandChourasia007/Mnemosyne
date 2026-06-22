# Mnemosyne

> Search as a library, not infrastructure.

Mnemosyne is an embedded search engine for Java applications.

The goal is to make text search as easy to embed as a database like SQLite or DuckDB:

```java
SearchEngine search = SearchEngine.open("search.idx");

search.add(document);

List<Result> results =
    search.search("java concurrency");
```

No servers.
No clusters.
No network calls.
No operational overhead.

Just a dependency and a search API.


---

## Current Status

🚧 Project initialization

The first milestone is a minimal in-memory search engine with:

- document indexing
- keyword search
- benchmarking infrastructure
- a stable public API

---

## Roadmap

### Phase 1
- [ ] Public API
- [ ] In-memory inverted index
- [ ] Basic querying
- [ ] Benchmarks

### Phase 2
- [ ] Persistence
- [ ] Ranking
- [ ] Segment architecture

### Phase 3
- [ ] Compression
- [ ] Concurrent indexing
- [ ] Query optimization

### Phase 4
- [ ] Advanced retrieval capabilities

---

## Why "Mnemosyne"?

In Greek mythology, Mnemosyne is the personification of memory.

Search is ultimately an act of memory and retrieval.

The goal of Mnemosyne is to provide applications with a fast, embedded memory system for information discovery.

---

## License

Apache License 2.0