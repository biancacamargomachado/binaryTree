//recebemos os índices da listagem pré-fixada, de um ponto para determinado ponto (inicialmente 0 e tamanho da listagem-1)
estruturaArvore(int de, int para) {
		//critério para definição de nodo folha nulo
        se (de > para)
            retorna null;
		
		//o valor de indice é 0 na primeira execução
        String nodoPreFixada = listagemPre.get(indice++);
		
		//Arvore: classe que contém a estrutura básica de uma árvore binária
        Arvore subarvore = nova Arvore(nodoPreFixada);
		
		//chegamos a uma extremidade
        se (de == para)
            retorna subarvore;
			
		//marcamos a posição  do elemento de indíce atual na listagem infixada
        int marca = listagemInfixada.indexOf(subarvore.elemento);
		
		//buscamos o nodo da esquerda, passando os novos índices para localizá-lo
        subarvore.esquerda = estruturaArvore(de, marca-1);
		
		//buscamos o nodo da direita, passando os novos índices para localizá-lo
        subarvore.direita = estruturaArvore(marca+1, para);
		
		//após a estrutura da árvore finalizada: é retornado o nodo raiz
		//a partir do qual é realizado o cáculo da altura
        retorna subarvore;
    }
	
	