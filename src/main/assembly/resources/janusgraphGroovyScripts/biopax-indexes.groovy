:remote connect tinkerpop.server conf/remote.yaml session 
:remote console 
graph.tx().commit()
m = graph.openManagement()
m.makeVertexLabel('DataSource:Resource').make()
m.makeVertexLabel('Comp:Concept:Resource').make()
m.makeVertexLabel('Concept:Resource:Transport').make()
m.makeVertexLabel('Concept:MolFunc:Resource').make()
m.makeVertexLabel('Concept:EC:Resource').make()
m.makeVertexLabel('Concept:Enzyme:Resource').make()
m.makeVertexLabel('Concept:Path:Resource').make()
m.makeVertexLabel('BioProc:Concept:Resource').make()
m.makeVertexLabel('Concept:Protcmplx:Resource').make()
m.makeVertexLabel('Accession:Resource').make()
m.makeVertexLabel('CelComp:Concept:Resource').make()
m.makeVertexLabel('Concept:Publication:Resource').make()
m.makeVertexLabel('Concept:Reaction:Resource').make()
m.makeVertexLabel('EvidenceType:Resource').make()
m.makeVertexLabel('Concept:Protein:Resource').make()
m.makePropertyKey('JOURNAL_REF').dataType(String.class).make()
m.makePropertyKey('iri').dataType(String.class).make()
m.makePropertyKey('identifier').dataType(String.class).make()
m.makePropertyKey('CML').dataType(String.class).make()
m.makePropertyKey('Mr').dataType(String.class).make()
m.makePropertyKey('AbstractHeader').dataType(String.class).make()
m.makePropertyKey('description').dataType(String.class).make()
m.makePropertyKey('AUTHORS').dataType(String.class).make()
m.makePropertyKey('prefName').dataType(String.class).make()
m.makePropertyKey('URL').dataType(String.class).make()
m.makePropertyKey('labelV').dataType(String.class).make()
m.makePropertyKey('labelV-idx').dataType(String.class).make()
m.makePropertyKey('YEAR').dataType(String.class).make()
m.makePropertyKey('TAXID').dataType(String.class).make()
m.makePropertyKey('altName').dataType(String.class).make()
m.makePropertyKey('knetLabel').dataType(String.class).make()
m.makeEdgeLabel('dc_identifier').multiplicity(MULTI).make()
m.makeEdgeLabel('evidence').multiplicity(MULTI).make()
m.makeEdgeLabel('is_part_of').multiplicity(MULTI).make()
m.makeEdgeLabel('in_by').multiplicity(MULTI).make()
m.makeEdgeLabel('pos_reg').multiplicity(MULTI).make()
m.makeEdgeLabel('relatedConcept').multiplicity(MULTI).make()
m.makeEdgeLabel('cs_by').multiplicity(MULTI).make()
m.makeEdgeLabel('ac_by').multiplicity(MULTI).make()
m.makeEdgeLabel('regulates').multiplicity(MULTI).make()
m.makeEdgeLabel('ca_by').multiplicity(MULTI).make()
m.makeEdgeLabel('pub_in').multiplicity(MULTI).make()
m.makeEdgeLabel('cat_c').multiplicity(MULTI).make()
m.makeEdgeLabel('neg_reg').multiplicity(MULTI).make()
m.makeEdgeLabel('pd_by').multiplicity(MULTI).make()
m.makeEdgeLabel('dataSource').multiplicity(MULTI).make()
m.makeEdgeLabel('is_a').multiplicity(MULTI).make()
m.makeEdgeLabel('part_of').multiplicity(MULTI).make()
m.makePropertyKey('labelE').dataType(String.class).make()
m.makePropertyKey('labelE-idx').dataType(String.class).make()
m.makePropertyKey('toIri').dataType(String.class).make()
m.makePropertyKey('fromIri').dataType(String.class).make()
m.makePropertyKey('evidenceValue').dataType(String.class).make()
m.makePropertyKey('Classification').dataType(String.class).make()
m.makePropertyKey('relatedConceptValue').dataType(String.class).make()
m.commit()

graph.tx().commit()
m = graph.openManagement()
prop = m.getPropertyKey('iri')
m.buildIndex('iriComp', Vertex.class).addKey(prop).buildCompositeIndex()
prop = m.getPropertyKey('iri')
m.buildIndex('iriMixed', Vertex.class).addKey(prop).buildMixedIndex('search')


prop = m.getPropertyKey('iri')
m.buildIndex('iriEdgeComp', Edge.class).addKey(prop).buildCompositeIndex()
prop = m.getPropertyKey('iri')
m.buildIndex('iriEdgeMixed', Edge.class).addKey(prop).buildMixedIndex('search')

prop = m.getPropertyKey('labelV-idx')
m.buildIndex('labelVComp', Vertex.class).addKey(prop).buildCompositeIndex()
prop = m.getPropertyKey('labelV-idx')
m.buildIndex('labelVMixed', Vertex.class).addKey(prop).buildMixedIndex('search')

prop = m.getPropertyKey('labelE-idx')
m.buildIndex('labelEComp', Edge.class).addKey(prop).buildCompositeIndex()
prop = m.getPropertyKey('labelE-idx')
m.buildIndex('labelEMixed', Edge.class).addKey(prop).buildMixedIndex('search')

prop = m.getPropertyKey('identifier')
m.buildIndex('identifierComp', Vertex.class).addKey(prop).buildCompositeIndex()
prop = m.getPropertyKey('identifier')
m.buildIndex('identifierMixed', Vertex.class).addKey(prop).buildMixedIndex('search')

prop = m.getPropertyKey('prefName')
m.buildIndex('prefNameComp', Vertex.class).addKey(prop).buildCompositeIndex()
prop = m.getPropertyKey('prefName')
m.buildIndex('prefNameMixed', Vertex.class).addKey(prop).buildMixedIndex('search')

prop = m.getPropertyKey('altName')
m.buildIndex('altNameComp', Vertex.class).addKey(prop).buildCompositeIndex()
prop = m.getPropertyKey('altName')
m.buildIndex('altNameMixed', Vertex.class).addKey(prop).buildMixedIndex('search')

prop = m.getPropertyKey('knetLabel')
m.buildIndex('knetLabelComp', Vertex.class).addKey(prop).buildCompositeIndex()
prop = m.getPropertyKey('knetLabel')
m.buildIndex('knetLabelMixed', Vertex.class).addKey(prop).buildMixedIndex('search')


m.commit()
ManagementSystem.awaitGraphIndexStatus(graph, 'iriComp').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'iriMixed').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'iriEdgeComp').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'iriEdgeMixed').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'labelVComp').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'labelVMixed').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'labelEComp').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'labelEMixed').call()

ManagementSystem.awaitGraphIndexStatus(graph, 'identifierComp').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'identifierMixed').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'prefNameComp').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'prefNameMixed').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'altNameComp').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'altNameMixed').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'knetLabelComp').call()
ManagementSystem.awaitGraphIndexStatus(graph, 'knetLabelMixed').call()

graph.tx().commit()
m = graph.openManagement()
idx = m.getGraphIndex('iriComp')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)
idx = m.getGraphIndex('iriMixed')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)

idx = m.getGraphIndex('iriEdgeComp')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)
idx = m.getGraphIndex('iriEdgeMixed')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)

idx = m.getGraphIndex('labelVComp')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)
idx = m.getGraphIndex('labelVMixed')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)

idx = m.getGraphIndex('labelEComp')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)
idx = m.getGraphIndex('labelEMixed')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)


idx = m.getGraphIndex('identifierComp')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)
idx = m.getGraphIndex('identifierMixed')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)

idx = m.getGraphIndex('prefNameComp')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)
idx = m.getGraphIndex('prefNameMixed')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)

idx = m.getGraphIndex('altNameComp')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)
idx = m.getGraphIndex('altNameMixed')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)

idx = m.getGraphIndex('knetLabelComp')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)
idx = m.getGraphIndex('knetLabelMixed')
m.updateIndex(idx, SchemaAction.ENABLE_INDEX)

m.commit()
graph.tx().commit()
:exit
