package ai.reveng.toolkit.ghidra.core.services.api.types;

import ghidra.program.model.listing.Program;


/**
 * Helper Datatype that encapsulates a Ghidra program with a binary ID and analysis ID
 * All functions that require a program to be known on the portal can use this to encode this assumption into the type system
 */
public record ProgramWithBinaryID(
        Program program,
        BinaryID binaryID
) {
}