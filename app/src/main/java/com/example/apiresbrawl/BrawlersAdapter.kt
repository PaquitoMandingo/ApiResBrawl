package com.example.apiresbrawl

class BrawlersAdapter : ListAdapter<Brawler, BrawlersAdapter.BrawlerViewHolder>(BrawlerDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrawlerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_brawler, parent, false)
        return BrawlerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrawlerViewHolder, position: Int) {
        val brawler = getItem(position)
        holder.bind(brawler)
    }

    class BrawlerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val rarityTextView: TextView = itemView.findViewById(R.id.rarityTextView)
        private val powerTextView: TextView = itemView.findViewById(R.id.powerTextView)
        private val healthTextView: TextView = itemView.findViewById(R.id.healthTextView)
        private val speedTextView: TextView = itemView.findViewById(R.id.speedTextView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(brawler: Brawler) {
            nameTextView.text = brawler.name
            rarityTextView.text = brawler.rarity
            powerTextView.text = brawler.power.toString()
            healthTextView.text = brawler.health.toString()
            speedTextView.text = brawler.speed.toString()
            Picasso.get().load(brawler.imagePath).into(imageView)
        }
    }

    class BrawlerDiffCallback : DiffUtil.ItemCallback<Brawler>() {
        override fun areItemsTheSame(oldItem: Brawler, newItem: Brawler): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Brawler, newItem: Brawler): Boolean {
            return oldItem == newItem
        }
    }
}