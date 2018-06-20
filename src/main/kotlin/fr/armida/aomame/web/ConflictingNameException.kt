package fr.armida.aomame.web

/**
 * THis exception should be use when we try to use a name that already exists.
 *
 * @author gfouquet
 */
class ConflictingNameException(val name: String, val type: Class<*>) : RuntimeException("A " + type.simpleName + " named " + name + " already exists")
