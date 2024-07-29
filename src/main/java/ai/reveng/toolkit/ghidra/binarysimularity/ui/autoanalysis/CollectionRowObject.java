package ai.reveng.toolkit.ghidra.binarysimularity.ui.autoanalysis;

import ai.reveng.toolkit.ghidra.core.services.api.types.Collection;

/**
 * Combined object for the immutable Collection record plus the mutable include flag.
 * This is used to display the collection name and include flag in the table,
 * while allowing the user to change the include flag.
 */
public class CollectionRowObject {
	private final Collection collection;
	private boolean include;
	
	public CollectionRowObject(Collection collection, boolean include) {
		this.collection = collection;
		this.include = include;
	}
	
	public String getCollectionName() {
		return collection.collectionName();
	}

	public boolean isInclude() {
		return include;
	}
	
	public void setInclude(boolean isInclude) {
		this.include = isInclude;
	}
}
