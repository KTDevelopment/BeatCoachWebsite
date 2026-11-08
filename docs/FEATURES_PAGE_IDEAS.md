# Ideen: Features-Seite weiter verbessern

Ergänzende Ideen für `#features` (`FeaturesScreen`) über die bereits umgesetzten Punkte hinaus:
- umgesetzt: **„So funktioniert’s“** (3 Schritte), **Nutzen-Satz je Sektion**, **Mini-FAQ** (5 Fragen), responsive Cards/CTA.

## Mittlerer Aufwand (UI/Code)
- **Interaktive Hervorhebung / Filter**: Chips wie *Üben*, *Organisieren*, *Playback/MIDI*; Sektionen oder Bullets werden hervorgehoben/gefiltert. Umsetzbar mit State in `FeaturesScreen` und Tags pro `FeatureSection`.
- **Aufklappbare Details (Progressive Disclosure)**: Grundinfo kurz, „Mehr anzeigen“ ergänzt konkrete Details (z. B. Part-Typen *Phrase/Accelerando/Ritardando*, Übungstypen *Silent Beat/Tempo Change/Song- & Part-Wiederholung*). Entlastet die Seite bei hoher Informationsdichte.
- **„Was macht BeatCoach besonders?“ (3–4 Highlights)**: kurze Kacheln für Alleinstellungsmerkmale, faktenbasiert (Parts mit eigenem Tempo, Audio + Metronom + Noten pro Song, zielgerichtete Übungen mit Fortschritt).
- **Sekundärer CTA**: neben dem Store-CTA optional „Tutorials ansehen“ (Link auf YouTube/`TUTORIALS_URL`-Kontext) für Nutzer in der Informationsphase.
- **Anker-/Sektionsnavigation** (Desktop/Tablet): kleine Sprunglinks/Chips zu den 7 Sektionen; auf Smartphone ggf. reduziert oder weggelassen.

## Höherer Nutzen (Assets/Entscheidungen nötig)
- **Aktuelle App-Screenshots pro Sektion** (oder 2–3 Key-Screens): größter Effekt für Glaubwürdigkeit. Bilder in `composeResources/drawable/`, Einbindung per `painterResource`, gute `contentDescription`-Strings (DE/EN). Nur mit gepflegten, aktuellen Screenshots.
- **Demo-Material**: kurzes Video/GIF oder Tutorial-Thumbnails. Im `wasmJs`-Web je nach Ansatz (Embed/externes Hosting) separat prüfen.
- **Social Proof** (nur falls vorhanden/verifiziert): Zitate, Pressestimmen oder verlässliche Store-Signale – keine erfundenen Angaben.

## Web/Qualität
- **SEO/Crawlability**: Hash-Routing (`#features`) ist für Crawling eingeschränkt; größere Maßnahmen ggf. separat (Seitenstruktur/Prerendering). Seitentexte und Überschriftenhierarchie dennoch klar halten.
- **Barrierefreiheit**: dekorative Icons mit `contentDescription = null` (wo Titel vorhanden), sinnvolle Labels für interaktive Elemente, Kontrastprüfung im `BeatCoachTheme`.
- **Begriffsklarheit**: `.beatcz` ggf. als „BeatCoach-Datei (.beatcz)“ erklären, wenn Zielgruppe das Format nicht kennt; Übungsnamen (*Silent Beat*) kurz kontextualisieren.

## Empfohlene nächste Schritte
1. Aufklappbare Details für **Songs/Parts** und **Übungen** (ohne neue Assets).
2. „Was macht BeatCoach besonders?“ als kompakter Block nach „So funktioniert’s“.
3. Screenshots einplanen, sobald aktuelle App-Bilder verfügbar sind.
